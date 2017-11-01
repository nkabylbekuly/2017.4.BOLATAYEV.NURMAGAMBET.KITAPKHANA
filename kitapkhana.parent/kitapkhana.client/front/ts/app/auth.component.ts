import {AfterViewInit, Component, ElementRef, EventEmitter, OnInit, Output, ViewChild} from "@angular/core";
import {HttpService} from "../service/HttpService";
import {error} from "util";
import {AuthInfo} from "../model/AuthInfo";

@Component({
    selector: 'auth-component',
    styles: [`
    `],
    template: `
        <div class="background-login">
        <header >
            <div class="col-md-12 login-header">
                
            <div class="col-md-7">
                <span style="font-size:20px;">LOGO</span>
            </div>
            <div class="col-md-5 login-form" >
                <form name="Form">
                    <md-input-container class="md-block" style="width: 100%">
                        <input mdInput #inputLogin placeholder="Login" name="fieldLogin"
                               [(ngModel)]="fieldLogin"  [disabled]="disabled" required>
                        <md-error>This field is required</md-error>
                    </md-input-container>
                    <md-input-container class="md-block" style="width: 100%">
                        <input mdInput #inputPassword placeholder="Password"  name="fieldPassword"
                               [(ngModel)]="fieldPassword" [disabled]="disabled" required>
                        <md-error>This field is required</md-error>
                    </md-input-container>
                    <button md-button (click)="enter()">Enter</button>
                    <md-error class="" *ngIf="errorMessage && !disabled">
                        {{errorMessage}}
                    </md-error>
                </form>
            </div>

            </div>
        </header>
    <div class="container">
       <div class="col-md-5">
       <div class="left-login-block">
        <h2>SLOGAN : Lorem ipsum dolor sit amet</h2>
        <p>
            Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum.
            Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum.
            Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum.
            Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum.
    
        </p>   
            <p style="text-align: right"><i><b>Kabylbekuly</b></i></p>
           
           
           
       </div>
       
       </div>
        <div class="col-md-7 right-login-block">
            <div>
            <h2>REGISTRATION BLOCK</h2>
                
                
                
                
                
                
                
                
                
                
            </div>










        </div>

    </div>
        <footer>
            <div class="col-md-12 login-footer">
              <h2><span>FOOTER</span></h2>
            </div>
            
            
        </footer></div>
    `
})
export class AuthComponent implements AfterViewInit, OnInit {

    errorMessage: string | null;

    fieldLogin: string = '';
    fieldPassword: string | null;

    disabled: boolean = false;

    @Output() finish = new EventEmitter<void>();

    constructor(private httpService: HttpService) {
    }

    ngOnInit(): void {
        console.log("AuthComponent 1")
    }

    ngAfterViewInit(): void {
        console.log("AuthComponent 2")
    }

    enter(): void {
        this.errorMessage = null;

        if (this.fieldLogin && this.fieldPassword) {
            this.disabled = true;
            this.httpService.post("/auth/login", {
                login: this.fieldLogin,
                password: this.fieldPassword
            }).toPromise().then(res => {
                this.disabled = false;
                let responce = res.json() as AuthInfo;
                this.httpService.token = responce.token;
                this.httpService.personId = responce.personId;

                this.finish.emit();

            }, error => {
                this.disabled = false;
                if (error.status == 470) {
                    this.errorMessage = error.text();
                } else {
                    console.error("AUTHENTICATION_UNKNOWN_ERROR", error);
                    this.errorMessage = error;
                }
            });

            this.fieldPassword = null;
        }
    }
}
