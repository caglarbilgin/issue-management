import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { ProjectComponent } from './project.component';
import { ProjectRoutingModule } from './project.rooting.module';
import { ProjectService } from 'src/app/services/shared/project.service';

@NgModule({
  declarations: [ProjectComponent],
  imports: [
    CommonModule,
    ProjectRoutingModule
  ],
  providers:[ProjectService]
})
export class ProjectModule { }
