import UserRepository from "../repository/UserRepository"
import * as httpStatus from "../../../config/constants/httpStatus"

class UserService {

    async findByEmail(req) {
        try {
            const { email } = req.params
            this.validateRequestData(email)
            let user = UserRepository.findById
            if (!user) {

            }
            return {
                status: httpStatus.SUCCESS,
                user: {
                    id: user.id,
                    name: user.name,
                    email: user.email,
                }
            }
        } catch (error) {
            return {
                status: error.status ? error.status : httpStatus.INTERNAL_SERVER_ERROR,
                message: error.message
            }
        }
    }

    validateRequestData(email) {
        if (!email) {
            throw new Error('User email was not informed.')
        }
    }
}

export default new UserService()