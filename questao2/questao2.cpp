/* Primeira aplicacao nativa em C para Android */ 

#include <stdio.h>
#include "android/log.h"  //system/core/liblog/include/android/log.h
#include "ziparchive/zip_writer.h" //system/core/libziparchive/include/ziparchive/zip_writer.h

void freeMemory(ZipWriter &writer, FILE* fileZip, FILE* fileTxt) {
    writer.FinishEntry();
    writer.Finish();
    fclose(fileZip);
    fclose(fileTxt);
}

int main(void)
{
    printf("\r\nOla, Eldorado Tech Trainning!\n");

    printf("\r\nNos somos Gabriel Alisson, Gabriel Maia, Henry Miller, Jonas Moreira e Jose Ricardo e esta eh a nossa primeira aplicacao em C nativa para Android!!!\n\n");

    const char* tag = "Questao2";
    __android_log_write(ANDROID_LOG_INFO, tag, "Iniciando a inclusão do file.txt em aulas.zip...");

    FILE* fileZip = fopen("/mnt/sdcard/Download/aulas.zip", "wb");
    FILE* fileTxt = fopen("/mnt/sdcard/Download/file.txt", "r");

    if (fileZip == nullptr || fileTxt == nullptr) {
        __android_log_write(ANDROID_LOG_ERROR, tag, "Erro na abertura do aulas.zip ou file.txt");
    	return 0;
    }

    int bufferSize = 80;
    char buffer[bufferSize];

    ZipWriter writer(fileZip);

    int result = writer.StartEntry("aulas/file.txt", ZipWriter::kCompress);
    if (result != 0) {
        __android_log_write(ANDROID_LOG_ERROR, tag, "Erro na criacao do file.txt em aulas.zip");
	freeMemory(writer, fileZip, fileTxt);
	return 0;
    }

    while(fgets(buffer, bufferSize, fileTxt)) {
	writer.WriteBytes(buffer, strlen(buffer));
    }

    if (ferror(fileTxt)) {
        __android_log_write(ANDROID_LOG_ERROR, tag, "Erro na leitura do arquivo file.txt");
	freeMemory(writer, fileZip, fileTxt);
	return 0;
    }

    freeMemory(writer, fileZip, fileTxt);
    __android_log_write(ANDROID_LOG_INFO, tag, "Concluido a inclusão do file.txt em aulas.zip");
    return 0;
}