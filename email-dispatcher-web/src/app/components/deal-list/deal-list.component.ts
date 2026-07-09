import { Component, OnInit } from '@angular/core';
import { CommonModule } from '@angular/common';
import { RouterLink } from '@angular/router';
import { FormsModule } from '@angular/forms';
import { DealService } from '../../services/deal.service';
import { Deal } from '../../services/deal.model';

@Component({
  selector: 'app-deal-list',
  standalone: true,
  imports: [CommonModule, RouterLink, FormsModule],
  template: `
    <div class="deal-list-container">
      <h1>Deals</h1>

      <div class="search-bar">
        <input
          type="text"
          [(ngModel)]="searchTerm"
          placeholder="Pesquisar deal..."
          class="search-input"
        />
      </div>

      <div class="loading" *ngIf="loading">Carregando deals...</div>

      <div class="error" *ngIf="error">
        <p>Erro ao carregar deals: {{ error }}</p>
        <button (click)="loadDeals()">Tentar novamente</button>
      </div>

      <div class="deals-grid" *ngIf="!loading && !error">
        <div *ngIf="filteredDeals.length === 0" class="no-results">
          Nenhum deal encontrado.
        </div>
        <a
          *ngFor="let deal of filteredDeals"
          [routerLink]="['/deals', deal.id]"
          class="deal-card"
        >
          <div class="deal-title">{{ deal.title }}</div>
          <div class="deal-contact">{{ deal.contact?.name }}</div>
          <div class="deal-date">{{ deal.createDate }}</div>
        </a>
      </div>
    </div>
  `,
  styles: [`
    .deal-list-container {
      padding: 1rem 0;
    }
    h1 {
      margin-bottom: 1.5rem;
      color: #1976d2;
    }
    .search-bar {
      margin-bottom: 1.5rem;
    }
    .search-input {
      width: 100%;
      padding: 0.75rem 1rem;
      font-size: 1rem;
      border: 1px solid #ddd;
      border-radius: 8px;
      outline: none;
      transition: border-color 0.2s;
    }
    .search-input:focus {
      border-color: #1976d2;
      box-shadow: 0 0 0 2px rgba(25, 118, 210, 0.1);
    }
    .loading {
      text-align: center;
      padding: 2rem;
      color: #666;
    }
    .error {
      text-align: center;
      padding: 2rem;
      color: #d32f2f;
    }
    .error button {
      margin-top: 1rem;
      padding: 0.5rem 1rem;
      background: #1976d2;
      color: white;
      border: none;
      border-radius: 4px;
      cursor: pointer;
    }
    .deals-grid {
      display: grid;
      grid-template-columns: repeat(auto-fill, minmax(300px, 1fr));
      gap: 1rem;
    }
    .deal-card {
      display: block;
      background: white;
      border-radius: 8px;
      padding: 1.5rem;
      box-shadow: 0 2px 4px rgba(0,0,0,0.08);
      transition: box-shadow 0.2s, transform 0.2s;
      text-decoration: none;
      color: inherit;
    }
    .deal-card:hover {
      box-shadow: 0 4px 12px rgba(0,0,0,0.15);
      transform: translateY(-2px);
      text-decoration: none;
    }
    .deal-title {
      font-size: 1.1rem;
      font-weight: 600;
      margin-bottom: 0.5rem;
      color: #1976d2;
    }
    .deal-contact {
      color: #555;
      margin-bottom: 0.25rem;
    }
    .deal-date {
      font-size: 0.85rem;
      color: #999;
    }
    .no-results {
      grid-column: 1 / -1;
      text-align: center;
      padding: 2rem;
      color: #666;
    }
  `]
})
export class DealListComponent implements OnInit {
  deals: Deal[] = [];
  searchTerm = '';
  loading = false;
  error = '';

  constructor(private dealService: DealService) {}

  ngOnInit(): void {
    this.loadDeals();
  }

  loadDeals(): void {
    this.loading = true;
    this.error = '';
    this.dealService.getAllDeals().subscribe({
      next: (response) => {
        this.deals = response.value;
        this.loading = false;
      },
      error: (err) => {
        this.error = err.message || 'Erro desconhecido';
        this.loading = false;
      }
    });
  }

  get filteredDeals(): Deal[] {
    if (!this.searchTerm.trim()) {
      return this.deals;
    }
    const term = this.searchTerm.toLowerCase();
    return this.deals.filter(deal =>
      deal.title.toLowerCase().includes(term) ||
      deal.contact?.name?.toLowerCase().includes(term)
    );
  }
}
