import Chatkit from '@pusher/chatkit-server';

const chatkit = new Chatkit.default({
    instanceLocator: "v1:us1:5955e381-23c2-4537-abc2-87353ec37557",
    key: "447c0dc4-6806-499f-a0e1-0335f58277ac:o5oG0BHx72Ir9adjA/F25MRYbbTRg3uvTWyzb66i69o=",
});

chatkit.createUser({
    id: '1',
    name: 'lemman',
})
    .then(() => {
        console.log('User created successfully');
    }).catch((err) => {
    console.log(err);
});


