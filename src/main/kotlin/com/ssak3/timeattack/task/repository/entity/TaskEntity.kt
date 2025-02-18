package com.ssak3.timeattack.task.repository.entity


import com.ssak3.timeattack.common.domain.BaseEntity
import com.ssak3.timeattack.member.domain.Member
import com.ssak3.timeattack.persona.repository.entity.PersonaEntity
import com.ssak3.timeattack.task.domain.TaskCategory
import com.ssak3.timeattack.task.domain.TaskStatus
import jakarta.persistence.Column
import jakarta.persistence.ConstraintMode
import jakarta.persistence.Entity
import jakarta.persistence.EnumType
import jakarta.persistence.Enumerated
import jakarta.persistence.ForeignKey
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id
import jakarta.persistence.JoinColumn
import jakarta.persistence.ManyToOne
import jakarta.persistence.Table
import java.time.LocalDateTime

@Entity
@Table(name = "task")
class TaskEntity(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    val id: Long? = null,

    @Column(name = "name")
    val name: String,

    @Enumerated(EnumType.STRING)
    @Column(name = "category")
    val category: TaskCategory,

    @Column(name = "due_datetime")
    var dueDatetime: LocalDateTime,

    @Column(name = "trigger_action")
    var triggerAction: String? = null,

    @Column(name = "estimated_time")
    var estimatedTime: Int? = null,

    @ManyToOne
    @JoinColumn(name = "task_type_id", nullable = false, foreignKey = ForeignKey(ConstraintMode.NO_CONSTRAINT))
    val taskType: TaskTypeEntity,

    @ManyToOne
    @JoinColumn(name = "task_mode_id", nullable = false, foreignKey = ForeignKey(ConstraintMode.NO_CONSTRAINT))
    val taskMode: TaskModeEntity,

    @Enumerated(EnumType.STRING)
    @Column(name = "status")
    var status: TaskStatus,

    @ManyToOne
    @JoinColumn(name = "member_id")
    val member: Member,

    @ManyToOne
    @JoinColumn(name = "persona_id")
    val persona: PersonaEntity,

    @Column(name = "is_delete")
    var isDelete: Boolean
) : BaseEntity()