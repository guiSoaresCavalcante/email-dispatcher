import { Component, OnInit } from '@angular/core';
import { CommonModule } from '@angular/common';
import { ActivatedRoute, RouterLink } from '@angular/router';
import { FormsModule } from '@angular/forms';
import { DealService } from '../../services/deal.service';
import { Deal, DispatchEmailRequest } from '../../services/deal.model';

@Component({
  selector: 'app-deal-detail',
  standalone: true,
  imports: [CommonModule, FormsModule, RouterLink],
  template: `
    <div class="deal-detail-container">
      <a routerLink="/" class="back-link">&larr; Voltar para deals</a>

      <div class="loading" *ngIf="loading">Carregando deal...</div>

      <div class="error" *ngIf="error">
        <p>Erro ao carregar deal: {{ error }}</p>
      </div>

      <div class="deal-form-container" *ngIf="!loading && !error && deal">
        <h1>{{ deal.title }}</h1>

        <form (ngSubmit)="onSubmit()" class="dispatch-form">
          <div class="form-group">
            <label for="email">Email</label>
            <input
              type="email"
              id="email"
              [(ngModel)]="formData.email"
              name="email"
              required
            />
          </div>

          <div class="form-group">
            <label for="title">Título</label>
            <input
              type="text"
              id="title"
              [(ngModel)]="formData.title"
              name="title"
              required
            />
          </div>

          <div class="form-group">
            <label for="contactName">Nome do Contato</label>
            <input
              type="text"
              id="contactName"
              [(ngModel)]="formData.contactName"
              name="contactName"
              required
            />
          </div>

          <div class="form-group">
            <label for="note">Anotações sobre a negociação</label>
            <textarea
              id="note"
              [(ngModel)]="formData.note"
              name="note"
              rows="5"
              required
            ></textarea>
          </div>

          <div class="form-group">
            <label for="additionalInfo">Informações Adicionais</label>
            <textarea
              id="additionalInfo"
              [(ngModel)]="formData.additionalInfo"
              name="additionalInfo"
              rows="3"
            ></textarea>
          </div>

          <div class="form-actions">
            <button type="submit" [disabled]="submitting" class="btn-submit">
              {{ submitting ? 'Enviando...' : 'Enviar Email' }}
            </button>
          </div>

          <div class="success-message" *ngIf="successMessage">
            {{ successMessage }}
          </div>
          <div class="error-message" *ngIf="submitError">
            {{ submitError }}
          </div>
        </form>
      </div>
    </div>
  `,
  styles: [`
    .deal-detail-container {
      padding: 1rem 0;
    }
    .back-link {
      display: inline-block;
      margin-bottom: 1.5rem;
      color: #1976d2;
      font-size: 0.95rem;
    }
    h1 {
      margin-bottom: 1.5rem;
      color: #1976d2;
    }
    .loading, .error {
      text-align: center;
      padding: 2rem;
    }
    .error {
      color: #d32f2f;
    }
    .deal-form-container {
      background: white;
      border-radius: 8px;
      padding: 2rem;
      box-shadow: 0 2px 4px rgba(0,0,0,0.08);
    }
    .dispatch-form {
      max-width: 600px;
    }
    .form-group {
      margin-bottom: 1.25rem;
    }
    .form-group label {
      display: block;
      margin-bottom: 0.4rem;
      font-weight: 500;
      color: #444;
    }
    .form-group input,
    .form-group textarea {
      width: 100%;
      padding: 0.6rem 0.8rem;
      font-size: 1rem;
      border: 1px solid #ddd;
      border-radius: 6px;
      outline: none;
      transition: border-color 0.2s;
      font-family: inherit;
    }
    .form-group input:focus,
    .form-group textarea:focus {
      border-color: #1976d2;
      box-shadow: 0 0 0 2px rgba(25, 118, 210, 0.1);
    }
    .form-actions {
      margin-top: 1.5rem;
    }
    .btn-submit {
      padding: 0.75rem 2rem;
      font-size: 1rem;
      background-color: #1976d2;
      color: white;
      border: none;
      border-radius: 6px;
      cursor: pointer;
      transition: background-color 0.2s;
    }
    .btn-submit:hover:not(:disabled) {
      background-color: #1565c0;
    }
    .btn-submit:disabled {
      background-color: #90caf9;
      cursor: not-allowed;
    }
    .success-message {
      margin-top: 1rem;
      padding: 0.75rem 1rem;
      background-color: #e8f5e9;
      color: #2e7d32;
      border-radius: 6px;
    }
    .error-message {
      margin-top: 1rem;
      padding: 0.75rem 1rem;
      background-color: #fbe9e7;
      color: #d32f2f;
      border-radius: 6px;
    }
  `]
})
export class DealDetailComponent implements OnInit {
  deal: Deal | null = null;
  loading = false;
  error = '';
  submitting = false;
  successMessage = '';
  submitError = '';

  formData: DispatchEmailRequest = {
    email: '',
    title: '',
    contactName: '',
    note: '',
    additionalInfo: ''
  };

  constructor(
    private route: ActivatedRoute,
    private dealService: DealService
  ) {}

  ngOnInit(): void {
    const id = Number(this.route.snapshot.paramMap.get('id'));
    this.loadDeal(id);
  }

  loadDeal(id: number): void {
    this.loading = true;
    this.error = '';
    this.dealService.getDealById(id).subscribe({
      next: (response) => {
        this.deal = response.value;
        this.formData = {
          email: this.deal.contact?.email || '',
          title: this.deal.title || '',
          contactName: this.deal.contact?.name || '',
          note: this.deal.contact?.informationNote || '',
          additionalInfo: ''
        };
        this.loading = false;
      },
      error: (err) => {
        this.error = err.message || 'Erro desconhecido';
        this.loading = false;
      }
    });
  }

  onSubmit(): void {
    this.submitting = true;
    this.successMessage = '';
    this.submitError = '';
    this.dealService.dispatchEmail(this.formData).subscribe({
      next: () => {
        this.successMessage = 'Email enviado com sucesso!';
        this.submitting = false;
      },
      error: (err) => {
        this.submitError = err.message || 'Erro ao enviar email';
        this.submitting = false;
      }
    });
  }
}
