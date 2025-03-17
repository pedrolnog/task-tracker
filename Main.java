import java.io.File;
import java.lang.reflect.Array;
import java.time.LocalDateTime;
import java.util.Scanner;
import java.util.ArrayList;

/*
The application should run from the command line, accept user actions and inputs as arguments, and store the tasks in a JSON file. The user should be able to:

- Add, Update, and Delete tasks
- Mark a task as in progress or done
- List all tasks
- List all tasks that are done
- List all tasks that are not done
- List all tasks that are in progress

Here are some constraints to guide the implementation:
- You can use any programming language to build this project.
- Use positional arguments in command line to accept user inputs.
- Use a JSON file to store the tasks in the current directory.
- The JSON file should be created if it does not exist.
- Use the native file system module of your programming language to interact with the JSON file.
- Do not use any external libraries or frameworks to build this project.
- Ensure to handle errors and edge cases gracefully.
*/

public class Main {
    static String[] criarTarefa(int tamanhoLista, String nomeTarefa) {
        LocalDateTime criadoEm = LocalDateTime.now();
        String[] tarefa = {"" + (tamanhoLista + 1), nomeTarefa, "todo", "" + criadoEm, "" + criadoEm};
        return tarefa;
    }

    public static void main(String[] args) {
        ArrayList<String[]> listaTarefas = new ArrayList<String[]>();
        listaTarefas.add(criarTarefa(listaTarefas.size(), "descricao"));

        while (true) {
            Scanner input = new Scanner(System.in);
            System.out.println("\nGerenciador de tarefas | CLI");
            System.out.print("task-cli ");

            String[] comando = (input.nextLine()).split(" ", 2);
            String[] parametros;

            if (comando[0] != "add") {
                parametros = comando[1].split(" ", 2);
            }
            

            switch (comando[0]) {
                case "add":
                    listaTarefas.add(criarTarefa(listaTarefas.size(), comando[1]));
                    break;
                case "update":
                    listaTarefas.get(parametros[0])[1] = parametros[1];
                    break;
            }



            for (int i = 0; i < listaTarefas.size(); i++) {
                System.out.print("\n");
                for (int n = 0; n < listaTarefas.get(i).length; n++) {
                    System.out.print(listaTarefas.get(i)[n] + " | ");
                }
            }
        }
    }
}