package fr.kars

import fr.kars.jooq.tables.daos.AttendPartyDao
import fr.kars.jooq.tables.daos.CityDao
import fr.kars.jooq.tables.daos.EvaluateProfilePartyDao
import fr.kars.jooq.tables.daos.InvitationPartyDao
import fr.kars.jooq.tables.daos.PartyDao
import fr.kars.jooq.tables.daos.PartySubtypeDao
import fr.kars.jooq.tables.daos.PartySubtypeListDao
import fr.kars.jooq.tables.daos.ProfileDao
import fr.kars.jooq.tables.daos.RequestPartyDao
import fr.kars.jooq.tables.daos.UserrDao
import jakarta.enterprise.inject.Produces
import org.jooq.Configuration

class DaoProducer {
    
    @Produces
    fun attendPartyDao(conf: Configuration) = AttendPartyDao(conf)

    @Produces
    fun cityDao(conf: Configuration) = CityDao(conf)

    @Produces
    fun evaluateProfilePartyDao(conf: Configuration) = EvaluateProfilePartyDao(conf)

    @Produces
    fun invitationPartyDao(conf: Configuration) = InvitationPartyDao(conf)

    @Produces
    fun partyDao(conf: Configuration) = PartyDao(conf)

    @Produces
    fun partySubtypeDao(conf: Configuration) = PartySubtypeDao(conf)

    @Produces
    fun partySubtypeListDao(conf: Configuration) = PartySubtypeListDao(conf)

    @Produces
    fun profileDao(conf: Configuration) = ProfileDao(conf)

    @Produces
    fun requestPartyDao(conf: Configuration) = RequestPartyDao(conf)

    @Produces
    fun userrDao(conf: Configuration) = UserrDao(conf)
}