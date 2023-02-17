import dominio.Bootcamp;
import dominio.Curso;
import dominio.Dev;
import dominio.Mentoria;

import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {

        Curso curso1 = new Curso();
        curso1.setTitulo("Curso Java");
        curso1.setDescricao("Curso de Java para iniciantes.");
        curso1.setCargaHoraria(8);

        Mentoria mentoria1 = new Mentoria();
        mentoria1.setTitulo("Mentoria de Java");
        mentoria1.setDescricao("Mentoria para os estudantes do curso de Java");
        mentoria1.setData(LocalDate.now());

        Bootcamp bootcamp1 = new Bootcamp();
        bootcamp1.setNome("Bootcamp Java Developer");
        bootcamp1.setDescricao("Bootcamp de Java e Spring para desenvolvedores");
        bootcamp1.getConteudos().add(curso1);
        bootcamp1.getConteudos().add(mentoria1);

        Dev aluno1 = new Dev();
        aluno1.setNome("Carla");
        aluno1.matricular(bootcamp1);

        System.out.println("Conteudos Inscritos de Carla: " + aluno1.getInscricoes());

        aluno1.progredir();

        System.out.println("Conteúdos Concluídos de Carla: " + aluno1.getConcluidos());
        System.out.println("Conteudos Inscritos de Carla: " + aluno1.getInscricoes());
        System.out.println("XP: " + aluno1.calcularXp());

    }
}
