package pl.pja.infrastructure.entities

import java.util.*
import javax.persistence.Column
import javax.persistence.Entity
import javax.persistence.Id
import javax.persistence.Table

@Entity
@Table(name = "App_User")
class UserEntity {

    @Id
    @Column(name = "IdUser")
    var id: String = UUID.randomUUID().toString()

    @Column(name = "Login", nullable = false)
    var login: String = ""

    @Column(name = "Email", nullable = false)
    var email: String = ""

    @Column(name = "HashedPassword", nullable = false)
    var password: String = ""

    @Column(name = "RefreshToken", nullable = false)
    var refreshToken: String = ""


}
