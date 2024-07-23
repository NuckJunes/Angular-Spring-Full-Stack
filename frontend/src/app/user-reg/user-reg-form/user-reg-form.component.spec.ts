import { ComponentFixture, TestBed } from '@angular/core/testing';

import { UserRegFormComponent } from './user-reg-form.component';

describe('UserRegFormComponent', () => {
  let component: UserRegFormComponent;
  let fixture: ComponentFixture<UserRegFormComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [UserRegFormComponent]
    })
    .compileComponents();
    
    fixture = TestBed.createComponent(UserRegFormComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
