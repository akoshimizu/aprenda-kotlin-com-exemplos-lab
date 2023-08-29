enum class Nivel {
    BASICO,
    INTERMEDIARIO,
    AVANCADO
}

class Aluno(val nomeUsuario: String, val idadeUsaurio: Int)

data class ConteudoEducacional(var nome: String, val duracao: Int = 60)

data class Formacao(val nome: String, val conteudos: List<ConteudoEducacional>, val nivelUsuario: Nivel) {

    var inscritos = mutableListOf<Aluno>()

    fun matricular(usuario: Aluno) {
        inscritos.add(usuario)
    }

    fun getAlunosInsc(nivel: Nivel) {
        println("Alunos da formação nível ${nivel}:")
        for(aluno in inscritos.sortedBy { it.nomeUsuario }) {
            println("Nome: ${aluno.nomeUsuario}, Idade: ${aluno.idadeUsaurio}")
        }
        println()
    }

    fun getConteudos(nivel: Nivel) {
        println("Conteúdos ${nivel}:")
        for(materia in conteudos.sortedBy { it.nome }) {
            println("Matéria: ${materia.nome}, Duração: ${materia.duracao}")
        }
        println()
    }

}


fun main(args: Array<String>) {

    val newUser = Aluno("Anderson", 32)
    val newUser2 = Aluno("Maria", 25)
    val newUser3 = Aluno("Joao", 20)

    val conteudosEduc = ConteudoEducacional("Kotlin - Intro á linguagem", 10)
    val conteudosEduc2 = ConteudoEducacional("Kotlin - POO", 40)
    val conteudosEduc3 = ConteudoEducacional("Kotlin - Arquitetura")
    val conteudosEduc4 = ConteudoEducacional("Android básico", 20)
    val conteudosEduc5 = ConteudoEducacional("Android Inter")
    val conteudosEduc6 = ConteudoEducacional("Android Avanc", 80)

    val listConteudoBas = mutableListOf<ConteudoEducacional>()
    listConteudoBas.add((conteudosEduc))
    listConteudoBas.add((conteudosEduc4))

    val listConteudoInter = mutableListOf<ConteudoEducacional>()
    listConteudoInter.add((conteudosEduc2))
    listConteudoInter.add((conteudosEduc5))

    val listConteudoAvanc = mutableListOf<ConteudoEducacional>()
    listConteudoAvanc.add((conteudosEduc3))
    listConteudoAvanc.add((conteudosEduc6))



    val formacaoBas = Formacao("Mobile Basico", listConteudoBas, Nivel.BASICO)
    val formacaoInter = Formacao("Mobile Intermediário", listConteudoInter, Nivel.INTERMEDIARIO)
    val formacaoAvan = Formacao("Mobile Avançado", listConteudoAvanc, Nivel.AVANCADO)


    formacaoBas.matricular(newUser)
    formacaoBas.matricular(newUser2)
    formacaoBas.matricular(newUser3)

    formacaoInter.matricular(newUser2)
    formacaoInter.matricular(newUser3)

    formacaoAvan.matricular((newUser3))

    formacaoBas.getAlunosInsc(formacaoBas.nivelUsuario)
    formacaoBas.getConteudos(formacaoBas.nivelUsuario)

    formacaoInter.getAlunosInsc(formacaoInter.nivelUsuario)
    formacaoInter.getConteudos(formacaoInter.nivelUsuario)

    formacaoAvan.getAlunosInsc(formacaoAvan.nivelUsuario)
    formacaoAvan.getConteudos(formacaoAvan.nivelUsuario)
}
