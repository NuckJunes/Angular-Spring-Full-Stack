import BasicUserDTO from "./BasicUserDTO";
export default interface TeamDTO {
    id: number,
    name: string,
    description: string,
    users: BasicUserDTO[]
};