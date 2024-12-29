package br.com.briansiervi.spring_batch_07_arquivo_multiplos_formatos.step;

import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.item.ItemWriter;
import org.springframework.batch.item.file.FlatFileItemReader;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import br.com.briansiervi.spring_batch_07_arquivo_multiplos_formatos.reader.ArquivoClienteTransacaoReader;

@Configuration
public class LeituraArquivoMultiplosFormatosStepConfig {
	@Autowired
	public StepBuilderFactory stepBuilderFactory;

	@SuppressWarnings({ "unchecked", "rawtypes" })
	@Bean
	public Step leituraArquivoMultiplosFormatosStep(
			FlatFileItemReader leituraArquivoMultiplosFormatosReader,
			ItemWriter leituraArquivoMultiplosFormatosItemWriter) {
		return stepBuilderFactory
				.get("leituraArquivoMultiplosFormatosStep")
				.chunk(1)
				.reader(new ArquivoClienteTransacaoReader(leituraArquivoMultiplosFormatosReader))
				.writer(leituraArquivoMultiplosFormatosItemWriter)
				.build();
	}
}
