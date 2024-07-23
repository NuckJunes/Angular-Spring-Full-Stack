import ProfileDTO from "./ProfileDTO";
export default interface BasicUserDTO {
    id: number,
    profile: ProfileDTO,
    isAdmin: boolean,
    active: boolean,
    status: string
};