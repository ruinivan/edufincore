import { Component } from '@angular/core';
import { RouterOutlet, RouterLink } from '@angular/router';

@Component({
  selector: 'app-main-layout',
  standalone: true,
  imports: [RouterOutlet, RouterLink], // Importante para o <router-outlet> funcionar
  templateUrl: './main-layout.html', // Apontando para o seu arquivo HTML
  styleUrl: './main-layout.scss', // Se tiver scss, ou style: '' se for inline
})
export class MainLayoutComponent {
  // Lógica do layout (ex: abrir/fechar menu mobile) viria aqui
}
