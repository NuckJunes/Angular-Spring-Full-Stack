import ProfileDTO from "./ProfileDTO";
import CompanyDTO from "./CompanyDTO";
import TeamDTO from "./TeamDTO";
export default interface FullUserDTO {
    id: number,
    profile: ProfileDTO,
    admin: boolean,
    active: boolean,
    status: string,
    companies: CompanyDTO[],
    teams: TeamDTO[]
};