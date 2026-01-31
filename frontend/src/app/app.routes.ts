import { Routes } from '@angular/router';
import { MainLayoutComponent } from '@core/layout/main-layout/main-layout';

export const routes: Routes = [
  {
    path: '',
    component: MainLayoutComponent, // O Shell carrega primeiro
    children: [
      {
        path: '',
        loadComponent: () =>
          import('@features/dashboard/dashboard/dashboard').then((m) => m.DashboardComponent), // Lazy Load do Dashboard
      },
      // Futuramente: path: 'tuition', loadComponent: ...
    ],
  },
  {
    path: '**',
    redirectTo: '',
  },
];
