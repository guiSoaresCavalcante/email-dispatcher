import { Routes } from '@angular/router';
import { DealListComponent } from './components/deal-list/deal-list.component';
import { DealDetailComponent } from './components/deal-detail/deal-detail.component';

export const routes: Routes = [
  { path: '', component: DealListComponent },
  { path: 'deals/:id', component: DealDetailComponent },
  { path: '**', redirectTo: '' }
];
