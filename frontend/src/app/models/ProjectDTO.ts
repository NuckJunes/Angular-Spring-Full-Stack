import TeamDTO from "./TeamDTO";
export default interface ProjectDTO {
    id: number,
    name: string,
    description: string,
    active: boolean,
    team: TeamDTO
};