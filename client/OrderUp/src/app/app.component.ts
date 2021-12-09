import { Component } from '@angular/core';
import * as $ from 'jquery';
import { authService } from './services/auth.service';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {
  title = 'OrderUp';
  public access: boolean = false;

  constructor(
    private _authService: authService,
  ){}
  
  ngOnInit(): void {
    
  }

  ngDoCheck() {
    this.access = this._authService.loggedIn()
  }

  noShow(){
  }

  logOut(){
    this._authService.logOut()
  }
}
