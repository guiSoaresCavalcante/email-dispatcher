import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { GetAllDealsResponse, GetDealByIdResponse, DispatchEmailRequest } from './deal.model';

@Injectable({
  providedIn: 'root'
})
export class DealService {
  private readonly baseUrl = '/api/v1';

  constructor(private http: HttpClient) {}

  getAllDeals(): Observable<GetAllDealsResponse> {
    return this.http.get<GetAllDealsResponse>(`${this.baseUrl}/crm/deals`);
  }

  getDealById(id: number): Observable<GetDealByIdResponse> {
    return this.http.get<GetDealByIdResponse>(`${this.baseUrl}/crm/deals/${id}`);
  }

  dispatchEmail(request: DispatchEmailRequest): Observable<void> {
    return this.http.post<void>(`${this.baseUrl}/dispatch-email/`, request);
  }
}
