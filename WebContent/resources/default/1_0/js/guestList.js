 $('#tblremoteeager').puidatatable({  
            caption: 'Remote Restful Webservice',  
            paginator: {  
                rows: 5  
            },  
            columns: [  
                {field:'guestName', headerText: 'Guest Name', sortable:true},  
                {field:'guestEmail', headerText: 'Guest Email', sortable:true},  
                {field:'guestAddress', headerText: 'Guest Address', sortable:true},  
                {field:'quantity', headerText: 'Quantity', sortable:true}  
            ],  
            datasource: function(callback) {  
                $.ajax({  
                    type: "GET",  
                    url: '/GetAllGuests',  
                    dataType: "json",  
                    context: this,  
                    success: function(response) {  
                        console.log(response);  
                    }  
                });  
            },  
            selectionMode: 'multiple',  
            rowSelect: function(event, data) {  
                $('#messages').puigrowl('show', [{severity:'info', summary: 'Row Selected', detail: (data.response.name + ' ' + data.response.email)}]);  
            },  
            rowUnselect: function(event, data) {  
                $('#messages').puigrowl('show', [{severity:'info', summary: 'Row Unselected', detail: (data.response.name + ' ' + data.response.email)}]);  
            }  
        }); 