package edu.prj.designpatterns.model;

import java.time.LocalDateTime;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * @autor Adriano Aparecido da Silva
 * <p>
 * Fiz uso do Projeto Lombok tem algumas annotations para minimizar o uso de
 * código repetitivo, como gettes e setters e EqualsAndHashCode.Além de não poluir visualmente o código
 * <p>
 * Relacionamnetos:
 * ManyToOne - Neste caso, podem haver vários status Financeiro(Financeiro)
 * para cada Aluno, mas cada Aluno está associado a apenas uma  status Financeiro(Financeiro)
 */

@Getter
@Setter
@EqualsAndHashCode
@NoArgsConstructor //Para uso do Hibernate
@AllArgsConstructor

@Entity
@Table(name = "tab_financeiro")
public class Financeiro {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "valor_sem_desconto", nullable = false)
    private Double valorSemDesconto;

    @Column(name = "valor_a_pagar", nullable = false)
    private double valorAPagar;// fazer o calculo com base na opçao escolhida de plano

    private StatusDePagamentoEnum statusDePagamento;

    @Column(name = "data_de_vencimento")
    private LocalDateTime dataDeVencimento;

    @OneToMany(cascade = {CascadeType.PERSIST,CascadeType.MERGE}, fetch = FetchType.LAZY)
    @JoinColumn(name = "financeiro_id",referencedColumnName = "id")
    private Set<Aluno> aluno;
}
