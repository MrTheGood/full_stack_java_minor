package dev.mrthegood.layers.models

import org.hibernate.annotations.CreationTimestamp
import org.hibernate.annotations.UpdateTimestamp
import java.time.Instant
import javax.persistence.GeneratedValue
import javax.persistence.Id
import javax.persistence.MappedSuperclass
import javax.persistence.Version

/**
 * Created by maartendegoede on 12/10/2020.
 * Copyright © 2020 Maarten de Goede. All rights reserved.
 */
@MappedSuperclass
class BaseEntity {
    @Id
    @GeneratedValue
    var id: Long? = null

    @Version
    var version: Int? = null

    @CreationTimestamp
    lateinit var createdAt: Instant

    @UpdateTimestamp
    lateinit var updatedAt: Instant

    /**
     * Id should never be null.
     * Since a Long cannot be lateinit and therefore it is easier to just give it the default value `null`.
     * Use this if you want the non-nullable id.
     */
    fun id() = id!!
}