import { Role } from "./Role";

export class User {
    constructor(
        public id: number,
        public name: string,
        public surname: string,
        public password: string,
        public email: string,
        public phone: number,
        public role_id: Role
    ){}

}