package com.scribblex.creditscore.data.entities

import com.google.gson.annotations.SerializedName


data class CoachingSummary(

    @SerializedName("activeTodo") var activeTodo: Boolean? = null,
    @SerializedName("activeChat") var activeChat: Boolean? = null,
    @SerializedName("numberOfTodoItems") var numberOfTodoItems: Int? = null,
    @SerializedName("numberOfCompletedTodoItems") var numberOfCompletedTodoItems: Int? = null,
    @SerializedName("selected") var selected: Boolean? = null

)