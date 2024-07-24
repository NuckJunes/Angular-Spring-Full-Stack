import ProfileDTO from "./ProfileDTO";

export default interface UserRequestDto{
    credentials: {
        username: string,
        password: string,
      },
      profile:ProfileDTO
      admin: false,
}