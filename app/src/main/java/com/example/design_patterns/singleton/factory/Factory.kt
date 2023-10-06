package com.example.design_patterns.singleton.factory

interface File {
    fun readFile()
    fun writeFile()
}

class XmlFile : File {
    override fun readFile() {
        println("READING XML FILE")
    }

    override fun writeFile() {
        println("WRITING XML FILE")
    }
}

class JsonFile : File {
    override fun readFile() {
        println("READING JSON FILE")
    }

    override fun writeFile() {
        println("WRITING JSON FILE")
    }
}

interface FileParserFactory {
    fun createFromFileName(fileName: String): File
}

class FileFactory : FileParserFactory {
    override fun createFromFileName(fileName: String): File {
        return when (fileName.substringAfterLast('.')) {
            "xml" -> XmlFile()
            "json" -> JsonFile()
            else -> throw Exception("Illegal file type $this")
        }
    }
}

fun String.createFileParser(): File {
    return when (this.substringAfterLast('.')) {
        "xml" -> XmlFile()
        "json" -> JsonFile()
        else -> throw Exception("Illegal file type $this")
    }
}


fun main() {
    val file1 = FileFactory().createFromFileName("someFile.xml")
    val file2 = "someFile.json".createFileParser()

    file1.writeFile()
    file2.readFile()
}