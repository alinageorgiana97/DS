import {UserViewRole} from './UserViewRole';


export class Patient {
  id: number;
  name: string;
  birthDate: string;
  gender: string;
  address: string;
  medicalRecord: string;
  userDTO: UserViewRole;
}
