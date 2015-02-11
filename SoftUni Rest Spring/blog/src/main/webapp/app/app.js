Ext.require(['Ext.data.*', 'Ext.grid.*']);

Ext.define('Blog', {
    extend: 'Ext.data.Model',
    fields: [{
            name: 'id',
            type: 'int',
            useNull: true
        }, 
        'name', 
        'description'],
    validations: [{
            type: 'length',
            field: 'name',
            min: 1
        }, {
            type: 'length',
            field: 'description',
            min: 1
        }]
});

Ext.onReady(function() {

    var store = Ext.create('Ext.data.Store', {
        autoLoad: true,
        autoSync: true,
        model: 'Blog',
        proxy: {
            type: 'rest',
            url: 'blog',
            extraParams: {
                page: 0
            },
            headers: {
                'Content-Type': 'application/json'
            },
            reader: {
                type: 'json',
                root: '_embedded.blog'
            },
            writer: {
                type: 'json'
            }
        }
    });

    var rowEditing = Ext.create('Ext.grid.plugin.RowEditing');

    var grid = Ext.create('Ext.grid.Panel', {
        renderTo: document.body,
        plugins: [rowEditing],
        width: 400,
        height: 300,
        frame: true,
        title: 'Blogs',
        store: store,
        columns: [{
                text: 'ID',
                width: 40,
                sortable: true,
                dataIndex: 'id'
            }, {
                text: 'Name',
                flex: 1,
                sortable: true,
                dataIndex: 'name',
                field: {
                    xtype: 'textfield'
                }
            }, {
                header: 'Description',
                width: 200,
                sortable: true,
                dataIndex: 'description',
                field: {
                    xtype: 'textfield'
                }
            }],
        dockedItems: [{
                xtype: 'toolbar',
                items: [{
                        text: 'Add',
                        iconCls: 'icon-add',
                        handler: function() {
                            // empty record
                            store.insert(0, new Blog());
                            rowEditing.startEdit(0, 0);
                        }
                    }, '-', {
                        text: 'Delete',
                        iconCls: 'icon-delete',
                        handler: function() {
                            var selection = grid.getView().getSelectionModel().getSelection()[0];
                            if (selection) {
                                store.remove(selection);
                            }
                        }
                    }]
            }]
    });
});
