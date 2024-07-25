import BasicUserDTO from "./BasicUserDTO";
import FullUserDTO from "./FullUserDTO";
export default interface AnnouncementDTO {
    id: number,
    date: string,
    title: string,
    message: string,
    author: FullUserDTO | undefined
};