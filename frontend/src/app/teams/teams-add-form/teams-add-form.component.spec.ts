import { ComponentFixture, TestBed } from '@angular/core/testing';

import { TeamsAddFormComponent } from './teams-add-form.component';

describe('TeamsAddFormComponent', () => {
  let component: TeamsAddFormComponent;
  let fixture: ComponentFixture<TeamsAddFormComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [TeamsAddFormComponent]
    })
    .compileComponents();
    
    fixture = TestBed.createComponent(TeamsAddFormComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
