package fr.kars.uc.impl

import fr.kars.HashedPassword
import fr.kars.Role
import fr.kars.UserId
import fr.kars.jooq.tables.references.USERR
import fr.kars.uc.GetRoleUseCase
import org.jooq.DSLContext

class DatabaseGetRoleUseCase(private val ctx: DSLContext): GetRoleUseCase {
    
    override fun invoke(userId: UserId, hashedPassword: HashedPassword): Role? {
        val role = ctx
            .select(USERR.USER_ID, USERR.PASSWORD, USERR.ROLE)
            .from(USERR)
            .where(USERR.USER_ID.eq(userId)).and(USERR.PASSWORD.eq(hashedPassword.toString()))
            .fetchOne()
            ?.get(USERR.ROLE)

        return when (role) {
            fr.kars.jooq.enums.Role.user -> Role.User
            fr.kars.jooq.enums.Role.admin -> Role.Admin
            null -> null
        }
    }
}