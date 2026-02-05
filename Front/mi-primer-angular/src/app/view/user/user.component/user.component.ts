import { Component } from '@angular/core';
/* Librerias a importar */
import { UserService } from '../../../services/user.service/user.service';
import { JsonPipe } from '@angular/common'
import { ChangeDetectorRef } from '@angular/core';

@Component({
  selector: 'app-user.component',
  imports: [],
  templateUrl: './user.component.html',
  styleUrl: './user.component.css',
  //template: '<p> Hola desdes user.component.ts</p>',

})
export class UserComponent {

  users: any[] = [];
  constructor(private userServi: UserService, private cdt: ChangeDetectorRef) {
    this.userServi.getUsers().subscribe(data => {
      this.users = data;
      console.log(this.users);
      this.cdt.detectChanges(); // Llamando al detector para rfrescar los cambios 

    })
  }

}