import BasicUserDTO from "./BasicUserDTO";
export default interface AnnouncementDTO {
    id: number,
    date: Date,
    title: string,
    message: string,
    author: BasicUserDTO
};