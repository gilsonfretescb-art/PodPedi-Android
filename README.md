# PodPedi + Entregas — projeto Android

Projeto inicial de APK Android (WebView) que abre o sistema publicado em **https://podpedientregas.netlify.app/**. Mantém o Supabase e as contas existentes; não cria banco novo nem altera as políticas RLS.

## Como gerar o APK sem instalar Android Studio no computador
1. Crie um repositório no GitHub e envie todos os arquivos desta pasta.
2. Abra **Actions** no repositório.
3. Execute **Build PodPedi APK** em **Run workflow** (ou aguarde o build automático após enviar para `main`/`master`).
4. Abra a execução concluída e baixe o artefato **PodPedi-Entregas-APK**. Dentro dele estará `app-debug.apk`.
5. Transfira o APK para o Android e instale. O aparelho pode pedir autorização para instalar apps dessa origem.

## O que este primeiro pacote faz
- Ícone e nome PodPedi + Entregas.
- Abre o sistema existente dentro de uma janela própria de app.
- JavaScript e armazenamento web habilitados para o login e a interface.
- Botão Voltar do Android navega para a página anterior.
- Links externos, incluindo navegação/mapas, são encaminhados para os apps compatíveis.
- O conteúdo continua vindo do site hospedado; atualizações feitas no site aparecem no app sem recompilar.

## Importante
- Este pacote é o **projeto-fonte**, não um APK já compilado. A compilação é feita pelo workflow do GitHub Actions.
- O app depende de internet e do site Netlify/Supabase estarem disponíveis.
- As permissões de administrador/motoboy continuam dependendo das regras e políticas já existentes no Supabase. Nunca coloque chave `service_role` no aplicativo.
- O destino do botão de GPS depende dos links de mapa presentes no sistema web; o wrapper encaminha links externos ao aplicativo de mapas.
- Antes de distribuir amplamente, testar login, recuperação de sessão, permissões, pedidos e repasses em um aparelho real.
