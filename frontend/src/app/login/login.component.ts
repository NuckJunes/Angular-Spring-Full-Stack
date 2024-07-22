import { Component } from '@angular/core';
import { post } from '../../services/api';

@Component({
  selector: 'app-login',
  standalone: true,
  imports: [],
  templateUrl: './login.component.html',
  styleUrl: './login.component.css'
})
export class LoginComponent {

  email: String = "";
  password: String = "";

  //Here we need to fetch a the user by username and password 
  //If that person exists, then we navigate to select company 

  async login() {
    //If we get a valid response, route to select company page
    let response = post("users", ["login"], {username: this.password})
    
  }

}
