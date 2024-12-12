package fr.kars.uc

import fr.kars.HashedPassword
import fr.kars.Role
import fr.kars.UserId

interface GetRoleUseCase {
    operator fun invoke(userId: UserId, hashedPassword: HashedPassword): Role?
}