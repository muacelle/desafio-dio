package dominio;

import java.util.LinkedHashSet;
import java.util.Objects;
import java.util.Optional;
import java.util.Set;

public class Dev {

    private String nome;
    private Set<Conteudo> inscricoes = new LinkedHashSet<>();
    private Set<Conteudo> concluidos = new LinkedHashSet<>();

    public void matricular (Bootcamp bootcamp) {
        this.inscricoes.addAll(bootcamp.getConteudos());
        bootcamp.getDevsInscritos().add(this);
    }

    public void progredir() {
        Optional<Conteudo> conteudo = this.inscricoes.stream().findFirst();
        if (conteudo.isPresent()) {
            this.concluidos.add(conteudo.get());
            this.inscricoes.remove(conteudo.get());
        } else {
            System.err.println("Você ainda não está matriculado em nenhum conteúdo.");
        }
    }

    public double calcularXp() {
        return this.concluidos
                .stream()
                .mapToDouble(Conteudo::calcularXp)
                .sum();
    }

    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }

    public Set<Conteudo> getInscricoes() {
        return inscricoes;
    }
    public void setInscricoes(Set<Conteudo> inscricoes) {
        this.inscricoes = inscricoes;
    }

    public Set<Conteudo> getConcluidos() {
        return concluidos;
    }
    public void setConcluidos(Set<Conteudo> concluidos) {
        this.concluidos = concluidos;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Dev dev = (Dev) o;
        return Objects.equals(nome, dev.nome) && Objects.equals(inscricoes, dev.inscricoes) && Objects.equals(concluidos, dev.concluidos);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nome, inscricoes, concluidos);
    }
}
