package com.example.movies.model

@Serializable
data class Creature (

    @SerialName(value="ability_scores")
    val strength: Int,
    val dexterity: Int,
    val constitution: Int,
    val intelligence: Int,
    val wisdom: Int,
    val charisma: Int,

    @SerialName("defenses")
    val fortitude: Int,
    val reflex: Int,
    val will: Int,
    val AC: Int,

    @SerialName(value="immunities")
    val immunities: List<String>,

    @SerialName(value="speeds")
    val speed: List<Int>,

    @SerialName(value="languages")
    val languages: List<String>,

    @SerialName(value="level")
    val level: Int,

    @SerialName(value="notes")
    val lore: String,

    @SerialName(value="traits")
    val traits: List<String>,
    val size: String,

)