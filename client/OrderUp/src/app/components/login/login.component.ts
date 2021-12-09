import { Component, OnInit } from '@angular/core';
import { Router,ActivatedRoute,Params } from '@angular/router';
import { authService } from 'src/app/services/auth.service';

@Component({
  selector: 'login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {
  public errorC: boolean = false
  public username:any = {
    username: "",
    password: ""
  }

  constructor(
    private _router: Router,
    private _authService: authService,
    ) { }

  ngOnInit(): void {
  }

  checkUser(form:any){
    if( this.username.username != "" && this.username.password != ""){
    // this._authService.singUp(this.username).subscribe(
      // response => {
        // sessionStorage.setItem('token', response.token)
        // this.errorC = false;
        // form.reset();
          this._router.navigate(['']);
      // },
      // err => {
        // console.log(err)
        // this.errorC = true;
      // }
    // )
    }
    
  }


}

