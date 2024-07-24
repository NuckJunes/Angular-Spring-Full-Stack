import BasicUserDTO from "./BasicUserDTO";
export default interface AnnouncementDTO {
    id: number,
    date: string,
    title: string,
    message: string,
    author: {
        profile: {
            firstName: string,
            lastName: string
        }
    }
};