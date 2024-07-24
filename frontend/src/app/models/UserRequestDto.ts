export default interface UserRequestDto{
    credentials: {
        username: '',
        password: '',
      },
      profile: {
        firstName: '',
        lastName: '',
        email: '',
        phone: ''
      },
      admin: false,
}