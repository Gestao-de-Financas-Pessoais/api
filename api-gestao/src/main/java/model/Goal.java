package model;

import enums.StatusGoal;
import jakarta.persistence.*;
import lombok.*;

import java.util.Date;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor

@Entity
@Table(name = "meta")
public class Goal {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idMeta;

    @ManyToOne
    private User idUsuario;

    private String nome;
    private Double valorObjetivo;
    private Double valorAtual;

    @Column(name = "status_meta")
    @Enumerated(EnumType.STRING)
    private StatusGoal statusMeta;

    private Date dataLimite;

}
