package model;

import enums.CategoryStatus;
import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor

@Entity
@Table(name = "categoira")
public class Category {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idCategoria;

    @ManyToOne
    private User idUsuario;

    private String nome;
    private CategoryStatus tipoTransacao;
}
