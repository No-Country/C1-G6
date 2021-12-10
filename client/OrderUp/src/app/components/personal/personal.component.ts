import { Component, OnInit } from '@angular/core';
import { UserService } from 'src/app/services/user.service';
@Component({
  selector: 'app-personal',
  templateUrl: './personal.component.html',
  styleUrls: ['./personal.component.css'],
  providers: [UserService]
})
export class PersonalComponent implements OnInit {

  constructor(
    private _UserService: UserService
  ) { }

  ngOnInit(): void {

  }

}
