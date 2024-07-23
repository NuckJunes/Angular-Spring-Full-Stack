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

  
  login() {
    //let response = post("users", ["login"], {username: this.password})
    
  }

}
