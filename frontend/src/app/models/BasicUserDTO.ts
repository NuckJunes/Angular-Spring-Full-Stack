import ProfileDTO from "./ProfileDTO";
export default interface BasicUserDTO {
    id: number,
    profile: ProfileDTO,
    admin: boolean,
    active: boolean,
    status: string
};