import BasicUserDTO from "./BasicUserDTO";
import TeamDTO from "./TeamDTO";
export default interface CompanyDTO {
    id: number,
    name: string,
    description: string
    teams: TeamDTO[] ;
  employees: BasicUserDTO[] ;
}