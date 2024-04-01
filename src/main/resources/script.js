const gerarChamado = async () => {

    let formulario = document.getElementById('formGerarChamado');
    let formData = new FormData(formulario);
    let btnAtivarChamado = document.getElementById('btnAtivarChamado');
    let mensagem = document.getElementById('mensagem');

    if (formulario.checkValidity()) {
        for (var key of formData.entries()) {
            console.log(key[0] + ", " + key[1]);
        }
        fetch(formulario.action, {
            method: 'POST',
            headers: {
                'Content-Type': 'application/x-www-form-urlencoded' // Definindo o tipo de conteúdo do corpo da requisição
            },
            body: new URLSearchParams(formData).toString() // Convertendo o FormData em uma string de parâmetros de URL
        })
            .then(response => response.text())
            .then(data => {
                // Exibir a mensagem retornada pelo servidor
                formulario.style.display = 'none';
                btnAtivarChamado.style.display = 'block';
                mensagem.style.color = 'black';
                mensagem.innerText = data;
                formulario.reset();
                obterDadosAtender();
            })
            .catch(error => {
                console.error('Erro ao enviar o formulário:', error);
            });
    } else {
        mensagem.style.color = "red";
        mensagem.innerText = 'Preencha todos os campos obrigatórios (*)';
    }
}

const cadastrarMedico = async () => {

    let formulario = document.getElementById('formCadastrarMedico');
    let formData = new FormData(formulario);
    let btnAtivarCadastroMed = document.getElementById('btnAtivarCadastroMed');
    let mensagem = document.getElementById('mensagemMedico');

    if (formulario.checkValidity()) {
        for (var key of formData.entries()) {
            console.log(key[0] + ", " + key[1]);
        }
        fetch(formulario.action, {
            method: 'POST',
            headers: {
                'Content-Type': 'application/x-www-form-urlencoded' // Definindo o tipo de conteúdo do corpo da requisição
            },
            body: new URLSearchParams(formData).toString() // Convertendo o FormData em uma string de parâmetros de URL
        })
            .then(response => response.text())
            .then(data => {
                // Exibir a mensagem retornada pelo servidor
                formulario.style.display = 'none';
                btnAtivarCadastroMed.style.display = 'block';
                mensagem.style.color = 'black';
                mensagem.innerText = data;
                formulario.reset();
            })
            .catch(error => {
                console.error('Erro ao enviar o formulário:', error);
            });
    } else {
        mensagem.style.color = "red";
        mensagem.innerText = 'Preencha todos os campos obrigatórios (*)';
    }
}

const ativarChamado = () => {
    let formulario = document.getElementById('formGerarChamado');
    let btnAtivarChamado = document.getElementById('btnAtivarChamado');
    let mensagem = document.getElementById('mensagem');

    formulario.style.display = 'block';
    btnAtivarChamado.style.display = 'none';
    mensagem.innerText = '';
}

const ativarCadastroMed = () => {
    let formulario = document.getElementById('formCadastrarMedico');
    let btnAtivarChamado = document.getElementById('btnAtivarCadastroMed');
    let mensagem = document.getElementById('mensagemMedico');

    formulario.style.display = 'block';
    btnAtivarChamado.style.display = 'none';
    mensagem.innerText = '';
}

const ativarDadosAtender = () => {
    let btnAtivarChamado = document.getElementById('btnAtivarAtualizacao');
    let mensagem = document.getElementById('mensagemAtualizacao');

    btnAtivarChamado.style.display = 'none';
    mensagem.innerText = '';
    obterDadosAtender();
}

const obterDadosAtender = () => {
    fetch('/api/solicitante/get', {method: 'GET'}) // Altere '/api/solicitante' para o endpoint correto do seu backend
        .then(response => response.json())
        .then(data => {
            // Montar a estrutura HTML para exibir os dados
            let html = '<table class="table table-bordered">';
            html += '<thead class="table-dark">' +
                '<th>Solicitante</th>' +
                '<th>Cidade</th>' +
                '</thead>';
            html += '<tbody style="cursor: pointer;">';
            data.forEach(item => {
                html += `<tr id="${item.id}">`;
                html += `<td>${item.nome}</td>`;
                html += `<td>${item.cidade}</td>`;
                html += '</tr>';
            });
            html += '<tbody>';
            html += '</table>';

            // Exibir os dados na seção "Atender"
            document.getElementById('dadosAtender').innerHTML = html;

            // Adicionando ouvinte de eventos para cada célula
            ///////
            const cells = document.querySelectorAll('#dadosAtender tbody tr');
            cells.forEach(cell => {
                cell.addEventListener('click', function () {
                    const id = this.getAttribute('id');
                    atualizarSolicitante(id);
                });
            });
            ////////

        })
        .catch(error => {
            console.error('Erro ao obter os dados:', error);
        });
}

const carregarMedicos = () => {
    fetch('/api/medico/get', { method: 'GET' })
        .then(response => response.json())
        .then(medicos => {
            const selectMedicos = document.getElementById('medico');
            selectMedicos.innerHTML = '';
            
            if (medicos == null || medicos.length === 0)
            {
                const option = document.createElement('option');
                option.textContent = "Nenhum médico cadastrado, faça o cadastro...";
                option.value = "";
                option.disabled = true;
                selectMedicos.appendChild(option);
            }
            
            medicos.forEach(medico => {
                const option = document.createElement('option');
                option.value = medico.id;
                option.textContent = `Médico: ${medico.nome} - CRM: ${medico.crm}`;
                selectMedicos.appendChild(option);
            });
            
        })
        .catch(error => {
            console.error('Erro ao obter a lista de médicos:', error);
        });
};

const atualizarSolicitante = (id) => {
    fetch(`/api/solicitante/${parseInt(id)}/get`, {method: 'GET'})
        .then(response => response.json())
        .then(data => {
            let html = '<form id="formAtualizarSolicitante">';

            html += `<div class="form-floating mb-3">
                            <input type="text" class="form-control" id="telefone" name="telefone" value="${data.telefone}" readonly>
                            <label for="telefone">Telefone</label>
                        </div>`;
            html += `<div class="form-floating mb-3">
                            <input type="text" class="form-control" id="nome" name="nome" value="${data.nome}" readonly>
                            <label for="nome">Solicitante</label>
                        </div>`;
            html += `<div class="form-floating mb-3">
                            <input type="text" class="form-control" id="logradouro" name="logradouro" value="${data.logradouro}" readonly>
                            <label for="logradouro">Logradouro</label>
                        </div>`;
            html += `<div class="form-floating mb-3">
                            <input type="text" class="form-control" id="bairro" name="bairro" value="${data.bairro}" readonly>
                            <label for="bairro">Bairro</label>
                        </div>`;
            html += `<div class="form-floating mb-3">
                            <input type="text" class="form-control" id="cidade" name="cidade" value="${data.cidade}" readonly>
                            <label for="cidade">Cidade</label>
                        </div>`;
            html += `<div class="form-floating mb-3"> *
                            <input type="text" class="form-control" id="diagnostico" name="diagnostico" required>
                            <label for="diagnostico">Diagnóstico</label>
                        </div>`;
            html += `<div class="form-floating mb-3"> *
                            <select class="form-select" id="medico" name="medico" onclick="carregarMedicos()" required>
                                <option value="" disabled selected>Selecione um médico...</option>
                            </select>
                        </div>`;
            html += `<div class="d-grid gap-2">
                        <button type="button" class="btn btn-success" onclick="atualizarFicha(${id})">Atualizar ficha</button>
                    </div>`;

            html += '</form>';
            
            document.getElementById('dadosAtender').innerHTML = html;
        })
        .catch(error => {
            console.error('Erro ao fazer a requisição GET:', error);
        });
}

const atualizarFicha = (idSolicitante) => {
    let formulario = document.getElementById('formAtualizarSolicitante');
    let formData = new FormData(formulario);
    const idMedico = document.getElementById('medico').value;
    
    formData.append("idSolicitante", idSolicitante);
    formData.append("idMedico", idMedico);
    
    console.log("dados da ficha atualizada");
    formData.forEach(data => console.log(data));
    let btnAtivarAtualizacao = document.getElementById('btnAtivarAtualizacao');
    let mensagem = document.getElementById('mensagemAtualizacao');

    if (formulario.checkValidity()) {
        fetch(`/api/solicitante/${idSolicitante}/update`, {
            method: 'PUT',
            headers: {
                'Content-Type': 'application/x-www-form-urlencoded' // Definindo o tipo de conteúdo do corpo da requisição
            },
            body: new URLSearchParams(formData).toString() // Convertendo o FormData em uma string de parâmetros de URL
        })
            .then(response => response.text())
            .then(data => {
                // Exibir a mensagem retornada pelo servidor
                formulario.style.display = 'none';
                btnAtivarAtualizacao.style.display = 'block';
                mensagem.style.color = 'black';
                mensagem.innerText = data;
                formulario.reset();
                obterDadosHistorico();
            })
            .catch(error => {
                console.error('Erro ao enviar o formulário:', error);
            });
    } else {
        mensagem.style.color = "red";
        mensagem.innerText = 'Preencha todos os campos obrigatórios (*)';
    }
}

const obterDadosHistorico = () => {
    fetch('/api/arquivo_solicitante/get', {method: 'GET'})
        .then(response => response.json())
        .then(data => {
            // Montar a estrutura HTML para exibir os dados
            let html = '<table class="table table-bordered">';
            html += '<thead class="table-dark">' +
                '<th>Solicitante</th>' +
                '<th>Cidade</th>' +
                '</thead>';
            html += '<tbody style="cursor: pointer;">';
            data.forEach(item => {
                html += `<tr id="${item.id}">`;
                html += `<td>${item.nome}</td>`;
                html += `<td>${item.cidade}</td>`;
                html += '</tr>';
            });
            html += '<tbody>';
            html += '</table>';

            document.getElementById('dadosHistorico').innerHTML = html;

            // Adicionando ouvinte de eventos para cada célula
            ///////
            const cells = document.querySelectorAll('#dadosHistorico tbody tr');
            cells.forEach(cell => {
                cell.addEventListener('click', function () {
                    const id = this.getAttribute('id');
                    exibirSolicitante(id);
                });
            });
            ////////

        })
        .catch(error => {
            console.error('Erro ao obter os dados:', error);
        });
}

const exibirSolicitante = (id) => {
    fetch(`/api/arquivo_solicitante/${parseInt(id)}/get`, {method: 'GET'})
        .then(response => response.json())
        .then(data => {
            let html = '<form id="formExibirSolicitante">';

            html += `<div class="form-floating mb-3">
                            <input type="text" class="form-control" id="telefone" name="telefone" value="${data.telefone}" readonly>
                            <label for="telefone">Telefone</label>
                        </div>`;
            html += `<div class="form-floating mb-3">
                            <input type="text" class="form-control" id="nome" name="nome" value="${data.nome}" readonly>
                            <label for="nome">Solicitante</label>
                        </div>`;
            html += `<div class="form-floating mb-3">
                            <input type="text" class="form-control" id="logradouro" name="logradouro" value="${data.logradouro}" readonly>
                            <label for="logradouro">Logradouro</label>
                        </div>`;
            html += `<div class="form-floating mb-3">
                            <input type="text" class="form-control" id="bairro" name="bairro" value="${data.bairro}" readonly>
                            <label for="bairro">Bairro</label>
                        </div>`;
            html += `<div class="form-floating mb-3">
                            <input type="text" class="form-control" id="cidade" name="cidade" value="${data.cidade}" readonly>
                            <label for="cidade">Cidade</label>
                        </div>`;
            html += `<div class="form-floating mb-3">
                            <input type="text" class="form-control" id="diagnostico" name="diagnostico" value="${data.diagnostico}" readonly>
                            <label for="diagnostico">Diagnóstico</label>
                        </div>`;
            html += `<div class="form-floating mb-3">
                            <input type="text" class="form-control" id="medico" name="medico" value="Médico: ${data.medico.nome} - CRM ${data.medico.crm}" readonly>
                            <label for="diagnostico">Médico responsável</label>
                        </div>`;
            html += `<div class="d-grid gap-2">
                        <button type="button" class="btn btn-primary" onclick="obterDadosHistorico()">Voltar</button>
                    </div>`;

            html += '</form>';

            document.getElementById('dadosHistorico').innerHTML = html;
        })
        .catch(error => {
            console.error('Erro ao fazer a requisição GET:', error);
        });
}


window.onload = () => {
    obterDadosAtender();
    obterDadosHistorico();
}