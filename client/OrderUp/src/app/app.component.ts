import { Component } from '@angular/core';
import * as $ from 'jquery';
import { authService } from './services/auth.service';
import { UserService } from './services/user.service';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css'],
  providers: [ UserService]
})
export class AppComponent {
  title = 'OrderUp';
  public access: boolean = false;
  public rol: number = 0;

  constructor(
    private _authService: authService,
    private _UserService: UserService
    ){}
  
  ngOnInit(): void {
    this.getRol();
  }

  ngDoCheck() {
    this.access = this._authService.loggedIn()
  }

  noShow(){
  }

  logOut(){
    this._authService.logOut()
    this.getRol();
  }

  getRol() {
    this._UserService.getUser().subscribe(
      response => {
        console.log(response);
        // this.rol = response.role.id
      },
      err => {
        console.log("-----------------------");
        console.log(err);
        console.log("-----------------------");
      }
    )
  }
}
